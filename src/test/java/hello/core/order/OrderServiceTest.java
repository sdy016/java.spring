package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;
import static org.assertj.core.api.Assertions.assertThat;

public class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    public String name = "memberA";
    public String itemName = "Sony A7c";

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, name, Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, itemName, 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
