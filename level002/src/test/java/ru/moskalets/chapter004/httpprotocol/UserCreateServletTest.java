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
public class UserCreateServletTest {
    @Test
    public void whenAddUserThenStoreIt() throws ServletException, IOException {
        Validate validate = new ValidateStub();
        PowerMockito.mockStatic(ValidateService.class);
        Mockito.when(ValidateService.getInstance()).thenReturn(validate);
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        when(req.getParameter("login")).thenReturn("User001");
        when(req.getParameter("password")).thenReturn("Password001");
        when(req.getParameter("role")).thenReturn("User");
        new UserCreateServlet().doPost(req, resp);
        assertThat(validate.findAll().values().iterator().next().getLogin(), is("User001"));
        assertThat(validate.findAll().values().iterator().next().getPassword(), is("Password001"));
        assertThat(validate.findAll().values().iterator().next().getRole(), is("User"));
    }
}