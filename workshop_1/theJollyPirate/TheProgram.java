import controller.MainControl;
import model.Registry;
import view.English;
import view.Mainview;

import java.time.LocalDate;

public class TheProgram {

    public static void main(String[] args){
      Mainview view = new English();
      Registry jollyPirate = new Registry();
      MainControl user = new MainControl(jollyPirate, view);


      while(user.getProgramRunning() == true){user.welcome();}
      view.programClosed();

    }

}


