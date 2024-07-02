package hotelReservation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerSignUp {
	
//	@NotBlank(message = "아이디는 필수 입력값입니다.")
	private String cid;
	
//	@NotBlank(message = "비밀번호는 필수 입력값입니다.")
//	@Pattern(regexp="(?=.*[0-9])(?=.*[a-z])(?=.*\\W)(?=\\S+$).{8,12}",
//    message = "비밀번호는 영문 소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 12자의 비밀번호여야 합니다.")
	private String cpw;
	
//	@NotBlank(message = "이름은 필수 입력값입니다.")
	private String cname;
	
//	@NotBlank(message = "영문 이름은 필수 입력값입니다.")
	private String firstname;
	
//	@NotBlank(message = "영문 성은 필수 입력값입니다.")
	private String lastname;
	
//	@NotBlank(message = "이메일은 필수 입력값입니다.")
//	@Email(message = "이메일 형식에 맞지 않습니다.")
	private String cmail;
	
	private String cphone;
	
	
	public CustomerSignUp() {}
	public CustomerSignUp(String cid, String cpw, String cname, 
			String firstname, String lastname, String cmail, String cphone) {
		this.cid = cid;
		this.cpw = cpw;
		this.cname = cname;
		this.firstname = firstname;
		this.lastname = lastname;
		this.cmail = cmail;
		this.cphone = cphone;
	}
	
}
