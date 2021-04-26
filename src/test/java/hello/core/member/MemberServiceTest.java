package hello.core.member;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

import hello.core.AppConfig;

public class MemberServiceTest {
  AppConfig appConfig = new AppConfig();
  MemberService memberService = appConfig.memberService();

  @Test
  void join() {
    // given
    Member member = new Member(1L, "MemeberA", Grade.VIP);
    // when
    memberService.join(member);
    Member findMember = memberService.findMember(1L);
    // then
    assertThat(member).isEqualTo(findMember);
  }
}
