package com.example.nit_guide;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ftab2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ftab2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ftab2 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    View rootView;
    private AdapterContacts adapter;
    private RecyclerView recyclerView;
    ArrayList<ModelContacts> contactList;

    private OnFragmentInteractionListener mListener;

    public ftab2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ftab2.
     */
    // TODO: Rename and change types and number of parameters
    public static ftab2 newInstance(String param1, String param2) {
        ftab2 fragment = new ftab2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        contactList=new ArrayList<>();
        contactList=dataqueue();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_ftab2, container, false);
        // 1. get a reference to recyclerView
        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_contactDep);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new AdapterContacts(getContext(),contactList);
        recyclerView.setAdapter(adapter);

        return rootView;
    }

    public ArrayList<ModelContacts> dataqueue(){
        ArrayList<ModelContacts> holder=new ArrayList<>();
        ModelContacts ob1=new ModelContacts();
        ob1.setHeading("Boys Hostels");
        ob1.setSubHeading("Wardens of respective hostels");
        ob1.setImgName(R.drawable.boyshostel);
        holder.add(ob1);

        ModelContacts ob2=new ModelContacts();
        ob2.setHeading("Girls Hostels");
        ob2.setSubHeading("Wardens of respective hostels");
        ob2.setImgName(R.drawable.girhostel);
        holder.add(ob2);

        return holder;

    }



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
