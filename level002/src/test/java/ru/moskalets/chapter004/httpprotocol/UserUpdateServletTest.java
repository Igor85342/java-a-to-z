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
public class UserUpdateServletTest {
    @Test
    public void whenUpdateUserThenStoreIt() throws ServletException, IOException {
        Validate validate = new ValidateStub();
        PowerMockito.mockStatic(ValidateService.class);
        Mockito.when(ValidateService.getInstance()).thenReturn(validate);
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        User user = new User(0,"User001", "Password001", "Admin");
        validate.add(user);
        when(req.getParameter("id")).thenReturn("0");
        when(req.getParameter("login")).thenReturn("User001u");
        when(req.getParameter("password")).thenReturn("Password001u");
        when(req.getParameter("role")).thenReturn("Admin");
        new UserUpdateServlet().doPost(req, resp);
        assertThat(validate.findAll().values().iterator().next().getLogin(), is("User001u"));
        assertThat(validate.findAll().values().iterator().next().getPassword(), is("Password001u"));
        assertThat(validate.findAll().values().iterator().next().getRole(), is("Admin"));
        assertThat(validate.findAll().get(0).getLogin(), is("User001u"));
    }
}