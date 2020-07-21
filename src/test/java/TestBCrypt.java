import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Administrator
 * @version 1.0
 **/
@RunWith(SpringRunner.class)
public class TestBCrypt {

    @Test
    public void testBCrypt(){

        //对密码进行加密
        String hashpw = BCrypt.hashpw("123", BCrypt.gensalt());
        System.out.println(hashpw);

        //校验密码
        boolean checkpw = BCrypt.checkpw("123", "$2a$10$aFsOFzujtPCnUCUKcozsHux0rQ/3faAHGFSVb9Y.B1ntpmEhjRtru");
        boolean checkpw2 = BCrypt.checkpw("123", "$2a$10$HuClcUqr/FSLmzSsp9SHqe7D51Keu1sAL7tUAAcb..FyILiLdFKYy");
        System.out.println(checkpw);
        System.out.println(checkpw2);
    }


    @Test
    public void PasswordEncoder(){
        PasswordEncoder passwordEncoder =
            PasswordEncoderFactories.createDelegatingPasswordEncoder();

        String aaa = passwordEncoder.encode("aab");
        System.out.println("加密后的密码"+aaa.substring(8));


        System.out.println(passwordEncoder.matches("aaa",aaa));
    }

    @Test
    public void UserTest(){
        User user  = (User)User.withDefaultPasswordEncoder()
            .username("aaa")
            .password("bbb")
            .roles("role")
            .build();
        System.out.println(user.getPassword());

    }

}
