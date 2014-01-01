package qa;



public class NavigationTabs extends CnnBase{

    public final static String us = "#nav-us";
    public final static String world = "#nav-world";
    public final static String politics = "#nav-politics";
    public final static String justice = "#nav-justice";
    public final static String entertainment = "#nav-entertainment";
    public final static String tech = "#nav-tech";
    public final static String health= "#nav-health";
    public final static String living = "#nav-living";
    public final static String travel = "#nav-travel";
    public final static String opinion = "#nav-opinion";

    public  void goToWorld(){
        clickByCss(world);
        System.out.print("a");
    }
    public void goToPolitics(){
        clickByCss(politics);
    }
    public void goToJustice(){
        clickByCss(justice);
    }
    public void goToEntertainment(){
        clickByCss(entertainment);
    }


} 