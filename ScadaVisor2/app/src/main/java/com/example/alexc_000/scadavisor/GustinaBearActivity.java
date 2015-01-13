package com.example.alexc_000.scadavisor;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.glass.app.Card;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexc_000 on 8/4/2014.
 */
public class GustinaBearActivity extends Activity {

    private List<Card> mCards;
    private CardScrollView mCardScrollView;

    private String Location = "Gustina-Bear 1-23H";
    private String LastDt = "07/28 8:30PM";
    private double BattV = 13.8;
    private double StatPSIA = 477.78;
    private double DiffinH2O = 29.2;
    private double TmpF = 96.81;
    private double CsgPSI = 2017.87;
    private double TbgPSI = 1951.5;
    private double MCFD = 2153.82;
    private double YstMCF = 2099.96;
    private double AccMCF = 163088.49;
    private double YstH20 = 3.62;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createCards();

        mCardScrollView = new CardScrollView(this);
        ExampleCardScrollAdapter adapter = new ExampleCardScrollAdapter();
        mCardScrollView.setAdapter(adapter);
        mCardScrollView.activate();
        setContentView(mCardScrollView);
    }

    private void createCards() {
        mCards = new ArrayList<Card>();

        Card card;

        card = new Card(this);
        card.setText(
                Location +
                        "\nLastDt: " + LastDt +
                        "\nBattV: " + BattV +
                        "\nStatPSIA: " + DiffinH2O
        );
        card.setFootnote("ScadaVisor, Page #1");
        mCards.add(card);

        card = new Card(this);
        card.setText(
                "StatPSIA: " + StatPSIA +
                        "\nDiffinH2O: " + DiffinH2O +
                        "\nTmpF: " + TmpF +
                        "\nCsgPSI: " + CsgPSI
        );
        card.setFootnote("ScadaVisor, Page #2");
        mCards.add(card);

        card = new Card(this);
        card.setText(
                "MCFD: " + MCFD +
                        "\nYstMCF: " + YstMCF +
                        "\nAccMCF: " + AccMCF +
                        "\nYstH2O: " + YstH20
        );
        card.setFootnote("ScadaVisor, Page #3");
        mCards.add(card);
    }

    private class ExampleCardScrollAdapter extends CardScrollAdapter {

        @Override
        public int getPosition(Object item) {
            return mCards.indexOf(item);
        }

        @Override
        public int getCount() {
            return mCards.size();
        }

        @Override
        public Object getItem(int position) {
            return mCards.get(position);
        }

        @Override
        public int getViewTypeCount() {
            return Card.getViewTypeCount();
        }

        @Override
        public int getItemViewType(int position){
            return mCards.get(position).getItemViewType();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return  mCards.get(position).getView(convertView, parent);
        }

    }
}