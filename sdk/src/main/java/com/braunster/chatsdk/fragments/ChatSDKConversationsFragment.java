/*
 * Created by Itzik Braun on 12/3/2015.
 * Copyright (c) 2015 deluge. All rights reserved.
 *
 * Last Modification at: 3/12/15 4:27 PM
 */

package com.braunster.chatsdk.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.braunster.chatsdk.R;
import com.braunster.chatsdk.Utils.Debug;
import com.braunster.chatsdk.fragments.abstracted.ChatSDKAbstractConversationsFragment;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

/**
 * Created by itzik on 6/17/2014.
 */
public class ChatSDKConversationsFragment extends ChatSDKAbstractConversationsFragment {

    private static final String TAG = ChatSDKConversationsFragment.class.getSimpleName();
    private static boolean DEBUG = Debug.ConversationsFragment;

    private AdView adView;

    public static ChatSDKConversationsFragment newInstance() {
        ChatSDKConversationsFragment f = new ChatSDKConversationsFragment();
        Bundle b = new Bundle();
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(inflateMenuItems);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mainView = inflater.inflate(R.layout.chat_sdk_activity_threads, container, false);

        initViews();

        loadDataOnBackground();

        ////////// Add Ad Banner by zhang
        adView = new AdView(this.getActivity());
        adView.setAdUnitId("USE YOUR OWN BANNER CODE");
        adView.setAdSize(AdSize.SMART_BANNER);
        adView = (AdView) mainView.findViewById(R.id.ad_view);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        ////////////////////
        return mainView;
    }

}
