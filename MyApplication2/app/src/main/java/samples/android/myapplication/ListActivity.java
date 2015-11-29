package samples.android.myapplication;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView98765;


public class ListActivity extends ActionBarActivity {
String[] names = {"ram", "sham", "ravi", "johny", "steve", "mike", "nick", "sham","mithun", "krishna","ram", "sham", "ravi", "johny", "steve", "mike", "nick", "sham","mithun", "krishna"} ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ListView listView = (ListView) findViewById(R.id.myListView);
        listView.setAdapter(new MyAdapter(names));

    }

    public class MyAdapter extends BaseAdapter{
       String[] names;
       public MyAdapter(String[] names) {
          this.names = names;
       }
        @Override
        public int getCount() {
            return names.length;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

           View view = convertView;

            if(view == null) {
                LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                inflater.inflate(R.layout.list_item, parent, false);
            }

          TextView textView = (TextView) view.findViewById(R.id.listItem);
            textView.setText(names[position]);

            return null;
        }


        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }
    }

}
