package a2dv606_aa223de.assignment_1;
        import android.app.Fragment;
        import android.graphics.Color;
        import android.os.Bundle;
        import android.text.Spannable;
        import android.text.SpannableString;
        import android.text.style.ForegroundColorSpan;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;

/**
 * Created by Abeer on 2015-08-27.
 */
public class My_Fragment extends Fragment {


    final static String NAME ="beer_name";
    final static String IMAGE ="image";
    final static String RATE = "rating";
    final static String BREWERY = "brewery";
    final static String STYLE = "style";
    final static String ABV= "abv";
    final static String REVIEW ="review";
    private ViewGroup rootView;



    public static My_Fragment create( int image, int name, int rate, int brewery, int style, int abv,
                                     int review) {
        My_Fragment newFragment = new My_Fragment();
        Bundle args = new Bundle();
        args.putInt(IMAGE,image);
        args.putInt(NAME, name);
        args.putInt(RATE, rate);
        args.putInt(BREWERY,brewery);
        args.putInt(STYLE,style);
        args.putInt(ABV,abv);
        args.putInt(REVIEW,review);
        newFragment.setArguments(args);
        return newFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout containing a header and body text.
        rootView = (ViewGroup) inflater.inflate(R.layout.my_fragment, container, false);
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();

        // During startup, check if there are arguments passed to the fragment.
        // onStart is a good place to do this because the layout has already been
        // applied to the fragment at this point so we can safely call the method
        // below that sets the header and body text.


        int image= 0 , nameText=0,rateText=0,breweryText=0,styleText=0, avrText=0,reviewText=0;
        Bundle args = getArguments();
        if (args != null) {

            nameText = args.getInt(NAME);
            rateText=args.getInt(RATE);
            breweryText=args.getInt(BREWERY);
            styleText=args.getInt(STYLE);
            avrText=args.getInt(ABV);
            reviewText =args.getInt(REVIEW);
            image= args.getInt(IMAGE);
        }


        ((TextView) rootView.findViewById(R.id.beer_name_view)).setText(nameText);
        ((TextView) rootView.findViewById(R.id.beer_brewery_view)).setText(breweryText);
        ((TextView) rootView.findViewById(R.id.beer_avr_view)).setText(avrText);
        ((TextView) rootView.findViewById(R.id.beer_style_view)).setText(styleText);
        ((TextView) rootView.findViewById(R.id.beer_rate_view)).setText(rateText);
        ((TextView) rootView.findViewById(R.id.beer_review_view)).setText(reviewText);
        ((ImageView) rootView.findViewById(R.id.imge_view)).setImageResource(image);

    }

}
