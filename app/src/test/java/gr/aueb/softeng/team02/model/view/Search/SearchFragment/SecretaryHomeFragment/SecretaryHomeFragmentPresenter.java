package gr.aueb.softeng.team02.model.view.Search.SearchFragment.SecretaryHomeFragment;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.softeng.team02.dao.Initializer;
import gr.aueb.softeng.team02.memorydao.MemoryInitializer;
import gr.aueb.softeng.team02.model.AcademicYearException;
import gr.aueb.softeng.team02.view.SecretaryHomeFragment.SecretaryHomePresenter;

public class SecretaryHomeFragmentPresenter {
    private Initializer init;
    private SecretaryHomePresenter presenter;
    private SecretearyHomeFragmentViewStub view;

    @Before
    public void setUp() throws AcademicYearException {
        init = new MemoryInitializer();
        init.prepareData();
        view = new SecretearyHomeFragmentViewStub();
        presenter = new SecretaryHomePresenter();
        presenter.setView(view);
    }

    @Test
    public void testLogout() {
        presenter.logout();
        Assert.assertEquals(1, view.getK());
    }

}
