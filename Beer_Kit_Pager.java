package a2dv606_aa223de.assignment_1;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.TextView;
import android.widget.Toast;
/**
 * Created by Abeer
 */

public class Beer_Kit_Pager extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pager_main);

        // Instantiate a ViewPager and a PagerAdapter.
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        PagerAdapter pagerAdapter = new MyPagerAdapter(getFragmentManager());
        pager.setAdapter(pagerAdapter);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            // This method will be invoked when a new page becomes selected.
            @Override
            public void onPageSelected(int position) {
              TextView pageNumView=  (TextView)findViewById(R.id.pager_num);
                int pageNum= position + 1;
                pageNumView.setText("Beer "+pageNum+" of out 7" );
             //   Toast.makeText(Beer_Kit_Pager.this,
                //       "Selected page position: " + position, Toast.LENGTH_SHORT).show();
            }

            // This method will be invoked when the current page is scrolled
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            // Called when the scroll state changes:
            // SCROLL_STATE_IDLE, SCROLL_STATE_DRAGGING, SCROLL_STATE_SETTLING
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private class MyPagerAdapter extends FragmentPagerAdapter {
        private Fragment[] fragments = new Fragment[7];

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);

            fragments[0] = My_Fragment.create( R.drawable.morningdelight,R.string.mornin_delight,R.string.mornin_rating,
                    R.string.mornin_brewery,R.string.mornin_style,R.string.mornin_abv,R.string.mornin_review);

            fragments[1] = My_Fragment.create( R.drawable.goodmorning,R.string.good_Morning,R.string.good_Morning_rating
                    ,R.string.good_Morning_brewery,R.string.good_Morning_style,R.string.good_Morning_ABV,R.string.good_Morning_review);

            fragments[2] = My_Fragment.create( R.drawable.plinytheyounger,R.string.pliny,R.string.pliny_rating,
                    R.string.pliny_brewery,R.string.pliny_style,R.string.pliny_abv,R.string.pliny_review);

            fragments[3] = My_Fragment.create( R.drawable.headytopper,R.string.heady,R.string.heady_rating,
                    R.string.heady_brewery,R.string.heady_style,R.string.heady_abv,R.string.heady_review);

            fragments[4] = My_Fragment.create( R.drawable.kentucky_brunch_brand_stout,R.string.kentucky,
                    R.string.kentucky_rating, R.string.kentucky_brewery,R.string.kentucky_style
                    ,R.string.kentucky_abv,R.string.kentucky_review);

            fragments[5] = My_Fragment.create( R.drawable.plinytheyounger,R.string.pliny,R.string.pliny_rating,
                    R.string.pliny_brewery,R.string.pliny_style,R.string.pliny_abv,R.string.pliny_review);

            fragments[6] = My_Fragment.create( R.drawable.norrlands,R.string.norrlands,R.string.norrlands_rating,
                    R.string.norrlands_brewery,R.string.norrlands_style,R.string.norrlands_abv,R.string.norrlands_review);

        }

        @Override
        public Fragment getItem(int position) {
            return fragments[position];

        }

        @Override
        public int getCount() {
            return fragments.length;
        }
    }


}

