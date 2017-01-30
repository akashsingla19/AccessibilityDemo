package com.example.demodemodemo;

import android.accessibilityservice.AccessibilityService;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/**
 * Created by akash on 24/1/17.
 */

public class DemoAccessibilityService extends AccessibilityService
{
    @Override
    public void onCreate() {
        super.onCreate();

        System.out.println("onCreate-------------------");
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {

        startHeadService();

        System.out.println("onAccessibilityEvent Action-------------------" + event.getAction());
        System.out.println("onAccessibilityEvent toString-------------------" + event.toString());
        System.out.println("onAccessibilityEvent describeContents-------------------" + event.describeContents());
        System.out.println("onAccessibilityEvent getEventType-------------------" + event.getEventType());
        System.out.println("onAccessibilityEvent getPackageName-------------------" + event.getPackageName());
        System.out.println("onAccessibilityEvent getRecordCount-------------------" + event.getRecordCount());
        System.out.println("onAccessibilityEvent getChildCount-------------------" + event.getSource().getChildCount());

        AccessibilityNodeInfo accessibilityNodeInfo = event.getSource();

        AccessibilityNodeInfo parent = null;

        while(accessibilityNodeInfo != null) {
            System.out.println("onAccessibilityEvent parent list -------------------" + accessibilityNodeInfo.getParent());
            accessibilityNodeInfo = accessibilityNodeInfo.getParent();

            if(accessibilityNodeInfo != null)
                parent = accessibilityNodeInfo;
        }


        System.out.println("**************************************************");

//        AccessibilityNodeInfo parentNode = event.getSource();
//
//        if(parentNode != null)
//        {
//            parentNode = parentNode.getParent();
//
//            int childCount = parentNode.getChildCount();
//
//            for(int i = 0; i < childCount; i++)
//            {
//                System.out.println("kaka =  " + parentNode.getChild(i));
//            }
//        }



        gety(parent);

        System.out.println("-----------------------------------------------");

//        accessibilityNodeInfo = event.getSource();
//
//        int childCount = accessibilityNodeInfo.getChildCount();
//
//        for(int i = 0; i < childCount; i++)
//        {
//            System.out.println("Child = " + accessibilityNodeInfo.getChild(i));
//        }

//        while(accessibilityNodeInfo != null) {
//            System.out.println("onAccessibilityEvent child list -------------------" + accessibilityNodeInfo.getC);
//            accessibilityNodeInfo = accessibilityNodeInfo.getParent();
//        }


    }


    private void gety(AccessibilityNodeInfo accessibilityNodeInfo)
    {

        if(accessibilityNodeInfo == null)
            return;


        int count = accessibilityNodeInfo.getChildCount();

        for(int i = 0; i < count; i++)
        {
//            System.out.println("node Class name = " + accessibilityNodeInfo.getClassName());
//
//            System.out.println("node = " + accessibilityNodeInfo.getViewIdResourceName());
//            System.out.println("node window Id  = " + accessibilityNodeInfo.getWindowId());

            System.out.println("Node = " + accessibilityNodeInfo.getChild(i));

            gety(accessibilityNodeInfo.getChild(i));
        }

    }


    @Override
    public void onInterrupt() {
System.out.println("onInterrupt-----------------------");
    }

    @Override
    public void unbindService(ServiceConnection conn) {
        super.unbindService(conn);
        System.out.println("unbindService---------------------------");
    }

    private void startHeadService() {

        initHeadLayer();
//        startService(new Intent(this, HeadService.class));
    }


    private void initHeadLayer() {
        HeadLayer mHeadLayer = new HeadLayer(this);
    }
}
