package com.banasiak.CalCount.calculation;

import com.banasiak.CalCount.model.user.Activity;
import com.banasiak.CalCount.model.user.Sex;
import com.banasiak.CalCount.model.user.UserInfo;
import com.banasiak.CalCount.model.user.UserMacro;

public class UserCaloricDemand {

    public static final double MAN_CONST = 88.362;
    public static final double MAN_WEIGHT_CONST = 13.397;
    public static final double MAN_HEIGHT_CONST = 4.799;
    public static final double MAN_AGE_CONST = 5.677;

    public static final double WOMAN_CONST = 447.593;
    public static final double WOMAN_WEIGHT_CONST = 9.247;
    public static final double WOMAN_HEIGHT_CONST = 3.098;
    public static final double WOMAN_AGE_CONST = 4.330;

    public static int calculateCaloricDemand(UserInfo userInfo){
        Sex sex = userInfo.getSex();
        double weight = userInfo.getWeight();
        double height = userInfo.getHeight();
        double age = userInfo.getAge();
        Activity activity = userInfo.getActivity();

        if(sex==null || weight == 0 || height == 0 || age == 0 || activity == null ){
            throw new NullPointerException("Data is not valid ,cant calculate");
        }


        if(sex.equals(Sex.MAN)){
            return (int)Math.round(((MAN_CONST + (MAN_WEIGHT_CONST*weight) + (MAN_HEIGHT_CONST*height) - (MAN_AGE_CONST*age))*activity.getValue()));
        }else {
            return (int)Math.round(((WOMAN_CONST + (WOMAN_WEIGHT_CONST*weight) + (WOMAN_HEIGHT_CONST*height) - (WOMAN_AGE_CONST*age))*activity.getValue()));
        }
    }
    public static int calculateFiber(UserInfo userInfo){
        if(userInfo.getSex().equals(Sex.MAN)){
            return 30;
        }else {
            return 25;
        }
    }

    public static int calculateProtein(UserInfo userInfo){
        if(userInfo.getSex().equals(Sex.MAN)){
            return (int)Math.round((userInfo.getWeight()*2)) ;
        }else {
            return (int)Math.round((userInfo.getWeight()*1.8));
        }
    }
    public static int calculateFat(UserInfo userInfo){
        if(userInfo.getSex().equals(Sex.MAN)){
            return (int)Math.round((userInfo.getWeight()*1.2));
        }else {
            return (int)Math.round((userInfo.getWeight()*1.5));
        }
    }

    public static int calculateCarbs(UserMacro macro){
        return (macro.getKcal() -((macro.getProtein()*4) + (macro.getFat()*9)))/4;
    }

    public static UserMacro calculateMacroOfDifferentNutrition(UserMacro userMacro, int nutrition)
    {
        return new UserMacro(
                (userMacro.getKcal()*nutrition)/100,
                (userMacro.getProtein()*nutrition)/100,
                (userMacro.getCarbs()*nutrition)/100,
                (userMacro.getFiber()*nutrition)/100,
                (userMacro.getFat()*nutrition)/100
        );
    }

}
