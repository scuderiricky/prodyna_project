package com.example.models;

import java.util.List;

public class ResourceSets {
 private final List<Resources> resources;

 public ResourceSets(List<Resources> resources){
  this.resources = resources;
 }

 public final List<Resources> getResources(){
  return resources;
 }

}
