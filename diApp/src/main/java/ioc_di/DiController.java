package ioc_di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//컨트롤러만 @Controller 라고 선언 
@Controller
public class DiController {  //mvc ->action(backend controller)
    @Autowired
    @Qualifier("samsungTV")  //-->DI DI 가있으려면 ioC 가있어야한다.? component = ioC 자동객체 생성// Autowired = DI 주입
    private TV tv;
    
    @Autowired
    @Qualifier("lgTV")  
    private TV tv2;
    
    //컨트롤러니까 요청 메소드는 문자열을 리턴할때는 view페이지 경로를 return 하는게 기본이다 view 페이지를 리턴할때는 @ResponseBody 를 빼면된다.
    @RequestMapping("/")  // / <- 경로로 요청이들어오면 root 이실행된후 return 된다. 
    public @ResponseBody String root() { // @ResponseBody 어노테이션을사용한다면 경로를반환하지않고 실제 데이터를 응답하려할때는 사용한다
      
      tv.powerOn();
      tv.volumeUp();
      tv.volumeDown();
      tv.powerOff();
      
      tv2.powerOn();
      tv2.volumeUp();
      tv2.volumeDown();
      tv2.powerOff();
      
      return "Annotation DI 사용하기";
    }
}
