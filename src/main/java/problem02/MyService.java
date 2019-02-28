package problem02;

public class MyService extends BaseService {

	public String afternoon() {

		return "오후";
	}

	@Override
	public void service(String state) {
		
		String result = state.equals("오후")? afternoon():(state.equals("낮")? day():night());
		
		System.out.println(result+"서비스시작");		
		
	}

}
