package br.dev.bs.avaliacao.core.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtils {

    public static String formatarData(Calendar data, String formato){
        if(data==null){
            return "data não informada";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
        return dateFormat.format(data.getTime());
    }

}
