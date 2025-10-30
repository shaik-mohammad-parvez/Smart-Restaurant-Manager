package com.restaurantapp;

import dagger.hilt.InstallIn;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedEntryPoint;

@OriginatingElement(
    topLevelClass = RestaurantApp.class
)
@GeneratedEntryPoint
@InstallIn(SingletonComponent.class)
public interface RestaurantApp_GeneratedInjector {
  void injectRestaurantApp(RestaurantApp restaurantApp);
}
