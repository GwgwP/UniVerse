package gr.aueb.softeng.team02.model.view.Logo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.team02.view.Logo.LogoActivityPresenter;

public class LogoPresenterTest {

    private LogoViewStub view;
    private LogoActivityPresenter presenter;

    @Before
    public void setUp() {
        view = new LogoViewStub();
        presenter = new LogoActivityPresenter(view);
    }

    /**
     * We test to see if the presenter calls the right method
     **/
    @Test
    public void testMoveScreen() {
        presenter.moveScreen();
        Assert.assertEquals(1, view.getK());
    }
}
