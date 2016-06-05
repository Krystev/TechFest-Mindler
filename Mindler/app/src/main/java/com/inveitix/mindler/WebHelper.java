package com.inveitix.mindler;

import android.util.Log;

import com.inveitix.mindler.cmn.DataTransferObject;
import com.inveitix.mindler.constants.QuerryTypes;
import com.inveitix.mindler.interfaces.WebDataListener;
import com.inveitix.mindler.tasks.WebDataTask;


public class WebHelper {
    public static WebHelper instance;

    private WebHelper() {
    }

    public static WebHelper getInstance() {
        if (instance == null) {
            instance = new WebHelper();
        }
        Log.d("ClientActivity", "instance");
        return instance;
    }

    public void getCities(final WebDataListener listener) {
        DataTransferObject dataTransferObject = new DataTransferObject();
        dataTransferObject.setData("-1");
        dataTransferObject.setQueryType(QuerryTypes.GET_CITY);
        new WebDataTask(listener, dataTransferObject).execute();
    }

    public void getSchools(final WebDataListener listener, int cityId) {
        DataTransferObject dataTransferObject = new DataTransferObject();
        dataTransferObject.setData(String.valueOf(cityId));
        dataTransferObject.setQueryType(QuerryTypes.GET_SCHOOL);
        new WebDataTask(listener, dataTransferObject).execute();
    }

    public void getDiscipline(final WebDataListener listener, int schoolId) {
        DataTransferObject dataTransferObject = new DataTransferObject();
        dataTransferObject.setData(String.valueOf(schoolId));
        dataTransferObject.setQueryType(QuerryTypes.GET_DISCIPLINE);
        new WebDataTask(listener, dataTransferObject).execute();
    }

    public void getTeachers(final WebDataListener listener, int schoolId, int disciplineId) {
        DataTransferObject dataTransferObject = new DataTransferObject();
        dataTransferObject.setData(String.valueOf(schoolId) + "|" + String.valueOf(disciplineId));
        dataTransferObject.setQueryType(QuerryTypes.GET_TEACHER);
        new WebDataTask(listener, dataTransferObject).execute();
    }

    public void getTest(final WebDataListener listener, int schoolId, int disciplineId, int teacherId) {
        DataTransferObject dataTransferObject = new DataTransferObject();
        dataTransferObject.setData(String.valueOf(schoolId) + "|" + String.valueOf(disciplineId)
                + "|" + String.valueOf(teacherId));
        dataTransferObject.setQueryType(QuerryTypes.GET_TEST);
        new WebDataTask(listener, dataTransferObject).execute();
    }

    public void getGame(final WebDataListener listener, int schoolId, int disciplineId, int teacherId) {
        DataTransferObject dataTransferObject = new DataTransferObject();
        dataTransferObject.setData(String.valueOf(schoolId) + "|" + String.valueOf(disciplineId)
                + "|" + String.valueOf(teacherId));
        dataTransferObject.setQueryType(QuerryTypes.GET_GAME);
        new WebDataTask(listener, dataTransferObject).execute();
    }

    public void createGame(final WebDataListener listener, int testId, String playerName) {
        DataTransferObject dataTransferObject = new DataTransferObject();
        dataTransferObject.setData(String.valueOf(testId) + "|" + playerName);
        dataTransferObject.setQueryType(QuerryTypes.CREATE_GAME);
        new WebDataTask(listener, dataTransferObject).execute();
    }

    public void enterGame(final WebDataListener listener, String gameUID, String playerName) {
        DataTransferObject dataTransferObject = new DataTransferObject();
        dataTransferObject.setData(gameUID + "|" + playerName);
        dataTransferObject.setQueryType(QuerryTypes.GET_TEST);
        new WebDataTask(listener, dataTransferObject).execute();
    }
}
