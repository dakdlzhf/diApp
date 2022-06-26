package ioc_di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("lgTV")
public class LgTV implements TV {
  
  @Autowired //AppleSpeaker 클래스가 있다면 객체를 자동 생성해준다 DI 부분 객체주입 ( hashCode 를 주입시켜준다 )
  private AppleSpeaker speaker;
  @Value("500000") //기본형으로 값을 넣어준다. price 에 500000 이  주입된다
  private int price;
  
  

  public LgTV() {
    System.out.println(">>>>>> Lg TV 객체생성");
  }

  @Override
  public void powerOn() {
    System.out.println("LgTV.....전원 켠다.(가격:"+price+")");

  }

  @Override
  public void powerOff() {
    System.out.println("LgTV....전원 끈다");

  }

  @Override
  public void volumeUp() {
    speaker.volumUp();

  }

  @Override
  public void volumeDown() {
    speaker.volumDown();

  }

}
