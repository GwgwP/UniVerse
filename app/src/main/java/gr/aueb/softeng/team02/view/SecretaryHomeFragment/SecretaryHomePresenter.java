package gr.aueb.softeng.team02.view.SecretaryHomeFragment;

public class SecretaryHomePresenter {

    private SecretaryHomeView view;

    public SecretaryHomePresenter() {
    }

    public void setView(SecretaryHomeView view) {
        this.view = view;
    }

    /**
     * Navigates the fragment to the Authentication screen
     **/
    public void logout() {
        view.escape();
    }
}
