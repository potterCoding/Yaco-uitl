import entity.User;
import org.junit.Test;

import java.util.Optional;

public class OptionalTest {

    /**
     * orElse和orElseGet的区别：
     * 当user值不为null时，orElse函数依然会执行createUser()方法，
     * 而orElseGet函数并不会执行createUser()方法
     * 至于orElseThrow，就是value值为null时,直接抛一个异常出去
     */
    @Test
    public void test01(){
        User user = new User();
        user.setName("lisi");
        user = Optional.ofNullable(user).orElse(createUser());
        System.out.println(user);
    }

    @Test
    public void test02() {
        User user = new User();
        user.setName("lisi");
        user = Optional.ofNullable(user).orElseGet(() -> createUser());
        System.out.println(user);
    }

    @Test
    public void test03() {
        User user = null;
        Optional.ofNullable(user).orElseThrow(() -> new RuntimeException("user not exsit!"));
    }

    @Test
    public void test04() {
        String str = "2020-11-27 13:51:23";
        str = str.substring(0,11) + "23:59:59";
        System.out.println(str);
    }


    private User createUser() {
        User user = new User();
        System.out.println("invoke createUser");
        user.setName("zhangSan");
        return user;
    }


}
