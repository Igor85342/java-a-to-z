package ru.moskalets.chapter004.httpprotocol;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
@RunWith(PowerMockRunner.class)
@PrepareForTest(ValidateService.class)
public class UserDeleteServletTest {
    @Test
    public void whenDeleteUser() throws ServletException, IOException {
        Validate validate = new ValidateStub();
        PowerMockito.mockStatic(ValidateService.class);
        Mockito.when(ValidateService.getInstance()).thenReturn(validate);
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        User user001 = new User(0,"User001", "Password001", "Admin");
        User user002 = new User(1,"User002", "Password002", "User");
        validate.add(user001);
        validate.add(user002);
        when(req.getParameter("id")).thenReturn("0");
        new UserDeleteServlet().doPost(req, resp);
        assertThat(validate.findAll().size(), is(1));
    }
}