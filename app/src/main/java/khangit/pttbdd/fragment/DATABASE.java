package khangit.pttbdd.fragment;

import java.util.ArrayList;

public class DATABASE { // Test Database
    public String[] textArray = {"data-01","data-01","data-01","data-01","data-01","data-01","data-01","data-01","data-01","data-01"};
    public Integer[] iconArray = {R.drawable.ic_avatar,R.drawable.ic_avatar,R.drawable.ic_avatar,R.drawable.ic_avatar,R.drawable.ic_avatar,R.drawable.ic_avatar,R.drawable.ic_avatar,R.drawable.ic_avatar,R.drawable.ic_avatar,R.drawable.ic_avatar};

    public class DbRecord{
        public String text;
        public Integer img;

        public DbRecord(String text, Integer img){
            this.text = text;
            this.img = img;
        }
    }

    public ArrayList<DbRecord> dbList = new ArrayList<>();

    public DATABASE(){
        for(int i = 0; i<textArray.length;i++){
            dbList.add(new DbRecord(textArray[i],iconArray[i]));
        }
    }
}
