package net.koreate.lombok;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

/*@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
	
	private int uno;
	//@Setter
	//@Getter
	private String uid;
	//@Setter
	//@Getter
	private String upw;
	private String uname;
	private Date regdate;
	
	@Singular("list")
	private List<String> friendList;
	
	

}
