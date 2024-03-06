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

    public static int calculateCaloricDemand(UserInfo userInfo, int typeOfNutrition){
        Sex sex = userInfo.getSex();
        double weight = userInfo.getWeight();
        double height = userInfo.getHeight();
        double age = userInfo.getAge();
        Activity activity = userInfo.getActivity();

        if(sex.equals(Sex.MAN)){
            return (int)Math.round((((MAN_CONST + (MAN_WEIGHT_CONST*weight) + (MAN_HEIGHT_CONST*height) - (MAN_AGE_CONST*age))*activity.getValue()) * typeOfNutrition) / 100);
        }else {
            return (int)Math.round((((WOMAN_CONST + (WOMAN_WEIGHT_CONST*weight) + (WOMAN_HEIGHT_CONST*height) - (WOMAN_AGE_CONST*age))*activity.getValue()) * typeOfNutrition) /100);
        }
    }
    public static int calculateFiber(UserInfo userInfo){
        if(userInfo.getSex().equals(Sex.MAN)){
            return 30;
        }else {
            return 25;
        }
    }

    public static int calculateProtein(UserInfo userInfo, int typeOfNutrition){
        if(userInfo.getSex().equals(Sex.MAN)){
            return (int)Math.round(((userInfo.getWeight()*2)* typeOfNutrition)/100) ;
        }else {
            return (int)Math.round(((userInfo.getWeight()*1.8) * typeOfNutrition) /100);
        }
    }
    public static int calculateFat(UserInfo userInfo, int typeOfNutrition){
        if(userInfo.getSex().equals(Sex.MAN)){
            return (int)Math.round(((userInfo.getWeight()*1.2) * typeOfNutrition)/100);
        }else {
            return (int)Math.round(((userInfo.getWeight()*1.5)*typeOfNutrition)/100);
        }
    }

    public static int calculateCarbs(UserMacro macro){
        return (macro.getKcal() -((macro.getProtein()*4) + (macro.getFat()*9)))/4;
    }

}
