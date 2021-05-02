package hello.core.Order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@RequiredArgsConstructor
//@Component
@Service
public class OrderServiceImpl implements OrderService {

  private final MemberRepository memberRepository;
  private final DiscountPolicy discountPolicy;
  //가급적이면 필드주입은 사용하지 말것(외부에서 변경이 불가능해서 테스트하기가 힘듬)

  /*@Autowired //타입매칭이 두개이상일경우 필드명을 빈 이름으로 변경
  private DiscountPolicy rateDiscontPolicy;*/


  /*@Autowired
  public void setMemberRepository(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  @Autowired
  public void setDiscountPolicy(DiscountPolicy discountPolicy) {
    this.discountPolicy = discountPolicy;
  }
  //Setter 주입(외부에서 수정하면 안되는 객체는 열어두면 안된다)*/

  @Autowired
  public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
    this.memberRepository = memberRepository;
    this.discountPolicy = discountPolicy;
  }//@Qualifier("mainDiscountPolicy") DiscountPolicy

  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);
    int discountPrice = discountPolicy.discount(member, itemPrice);
    return new Order(memberId, itemName, itemPrice, discountPrice);
  }

  //스프링빈 싱글톤패턴 테스트용도
  public MemberRepository getMemberRepository() {
    return memberRepository;
  }
}
