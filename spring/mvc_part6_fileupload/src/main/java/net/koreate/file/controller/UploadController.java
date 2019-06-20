package net.koreate.file.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import net.koreate.file.util.UploadUtils;

@Controller
public class UploadController {
	
	@Resource(name="uploadPath")
	String uploadPath;
	
	// @Inject
	// @Autowired
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
		
	@GetMapping("/uploadForm")
	public void uploadForm() {
		System.out.println("업로드 화면 요청");
		System.out.println("uploadPath : "+uploadPath);
		File file = new File(uploadPath);
		if(!file.exists()) {
			file.mkdirs();
			System.out.println("경로 생성 완료");
		}
	}
	
	@PostMapping("/uploadForm")
	public String uploadForm(MultipartFile file, Model model) throws IOException{
		System.out.println("Post 요청 UploadForm");
		System.out.println("file name : " + file.getOriginalFilename());
		System.out.println("file size : " + file.getSize());
		System.out.println("file type : " + file.getContentType());
		
		String savedName = uploadFile(file.getOriginalFilename(),file.getBytes());
		model.addAttribute("savedName",savedName);
		return "uploadResult";
	}
	
	@PostMapping("uploadForm1")
	public String uploadForm(MultipartFile[] file ,Model model) throws IOException {
		String[] savedNames = new String[file.length];
		
		for(int i=0; i <file.length; i++) {
			savedNames[i] = uploadFile(file[i].getOriginalFilename(),file[i].getBytes());
		}
		
		model.addAttribute("savedNames",savedNames);		
		return "uploadResult";
	}
	
	@PostMapping("/uploadForm2")
	public String uploadForm(MultipartHttpServletRequest request, Model model) throws IOException {
		String auth = request.getParameter("auth");
		MultipartFile file = request.getFile("file");
		MultipartFile file1 = request.getFile("file1");
		System.out.println("auth : "+auth);
		
		String originalFile = file.getOriginalFilename();
		String originalFile1 = file1.getOriginalFilename();
		
		String[] savedNames = new String[2];
		
		savedNames[0] = uploadFile(originalFile,file.getBytes());
		savedNames[1] = uploadFile(originalFile1,file1.getBytes());
		
		model.addAttribute("savedNames",savedNames);
		
		return "uploadResult";
	}
	
	@PostMapping("/uploadForm3")
	public String uploadForm3(MultipartHttpServletRequest request ,Model model) throws IOException{
		
		String auth = request.getParameter("auth");
		System.out.println("auth : "+auth);
		
		MultipartFile file1 = request.getFile("file1");
		
		List<MultipartFile> fileList = request.getFiles("file");
		
		String[] savedNames = new String[fileList.size()+1];
		
		for(int i=0; i<fileList.size(); i++) {
			MultipartFile file = fileList.get(i);
			savedNames[i] = uploadFile(file.getOriginalFilename(),file.getBytes());
		}
		
		savedNames[savedNames.length-1] = uploadFile(file1.getOriginalFilename(), file1.getBytes());
		
		model.addAttribute("savedNames",savedNames);
		
		return "uploadResult";
	}
	
	@GetMapping("/uploadAjax")
	public void uploadAjax() {}
	
	
	@GetMapping("/displayFile")
	@ResponseBody
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception{		
		return UploadUtils.displayFile(uploadPath,fileName);
	}
	
	
	
	
	@PostMapping(value="/uploadAjax", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public ResponseEntity<String> uploadAjax(MultipartFile file) throws IOException{
		String originalName = file.getOriginalFilename();		
		System.out.println(originalName);
		
		ResponseEntity<String> entity = null;
		
		String uploadFileName = null;
		
		try {
			uploadFileName = UploadUtils.uploadFile(originalName, uploadPath, file.getBytes());
			entity = new ResponseEntity<>(uploadFileName,HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}		
		return entity;
	}  
	
	
	
	
	
	
	
	
	
	
	
	
	public String uploadFile(String originalName,byte[] filedata)
			throws IOException{
		// 32개의 십육진수와 4개의 '-'으로 된 36자리의 랜덤한 문자열을 리턴
		UUID uid = UUID.randomUUID();
		System.out.println(uid);
		
		String savedName = uid.toString().replace("-", "")+"_"+originalName;
		System.out.println(savedName);
		File file = new File(uploadPath,savedName);
		
		// 파일 출력
		FileCopyUtils.copy(filedata, file);
				
		return savedName;
	}
	
	
}
