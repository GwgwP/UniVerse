package gr.aueb.softeng.team02.view.Logo;

public class LogoActivityPresenter {
    private LogoActivityView view;

    /**
     * Constructor that initializes the view
     *
     * @param view : the desired view
     **/
    public LogoActivityPresenter(LogoActivityView view) {
        this.view = view;
    }

    /**
     * Navigates the screen
     **/
    public void moveScreen() {
        view.gotToHomeScreen();
    }
}
