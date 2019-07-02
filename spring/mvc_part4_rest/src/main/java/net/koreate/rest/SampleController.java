package net.koreate.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import net.koreate.rest.vo.SampleVO;

@Controller
public class SampleController {

	@GetMapping("/testJson")
	public String testJson(Model model) {
		model.addAttribute("hello hihihihi");		
		return "JSON";
	}
	
	@GetMapping("/sendSampleVO")
	public String sendSampleVO(Model model) {		
		SampleVO sample = new SampleVO();
		sample.setName("자바수업");
		sample.setAge(33);
		model.addAttribute("sample",sample);
		return "JSON";
	}
	
	@GetMapping("/getSample")
	@ResponseBody
	public SampleVO getSample(SampleVO sample) {
		System.out.println("getSample 요청");		
		System.out.println(sample);
		return sample;
	}
	
	@PostMapping("/getSample")
	@ResponseBody
	public List<SampleVO> getSamplePost(@RequestBody SampleVO sample){
		System.out.println("POST getSample 요청");
		System.out.println(sample);
		List<SampleVO> sampleList = new ArrayList<>();
		sampleList.add(sample);
		
		for(int i=0; i <10; i++) {
			SampleVO s = new SampleVO();
			s.setName("name"+i);
			s.setAge(i);
			sampleList.add(s);
		}		
		return sampleList;
	}
	
	@PutMapping("/getSample2")
	@ResponseBody
	/*@RequestMapping(value="/getSample2",mothod=RequestMethod.PUT)*/
	public SampleVO getSample2(@RequestBody SampleVO sample) {
		System.out.println(sample);		
		return sample;
	}
	
}
