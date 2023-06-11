package gr.aueb.softeng.team02.model.view.Search.SearchFragment.SecretaryHomeFragment;

import gr.aueb.softeng.team02.view.SecretaryHomeFragment.SecretaryHomeView;

public class SecretearyHomeFragmentViewStub implements SecretaryHomeView {
    int k = 0;
    @Override
    public void escape() {
        k++;
    }

    public int getK(){
        return k ;
    }
}
