package gr.aueb.softeng.team02.model.view.Logo;

import gr.aueb.softeng.team02.view.Logo.LogoActivityView;

public class LogoViewStub implements LogoActivityView {
   int k =0;
    @Override
    public void gotToHomeScreen() {
        k++;
    }
    public int getK(){
        return k ;
    }
}
