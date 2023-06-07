package gr.aueb.softeng.team02.view.Logo;

public class LogoActivityPresenter {
    LogoActivityView view;

    public LogoActivityPresenter(LogoActivityView view) {
        this.view = view;
    }

    public void moveScreen() {
        view.gotToHomeScreen();
    }
}
