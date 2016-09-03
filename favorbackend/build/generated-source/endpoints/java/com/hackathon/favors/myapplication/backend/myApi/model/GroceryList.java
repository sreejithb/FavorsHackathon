/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://github.com/google/apis-client-generator/
 * (build: 2016-07-08 17:28:43 UTC)
 * on 2016-09-03 at 20:26:40 UTC 
 * Modify at your own risk.
 */

package com.hackathon.favors.myapplication.backend.myApi.model;

/**
 * Model definition for GroceryList.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the myApi. For a detailed explanation see:
 * <a href="https://developers.google.com/api-client-library/java/google-http-java-client/json">https://developers.google.com/api-client-library/java/google-http-java-client/json</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class GroceryList extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String address;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String deliverer;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.util.List<java.lang.String> items;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer jobid;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer nearby;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String owner;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String status;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getAddress() {
    return address;
  }

  /**
   * @param address address or {@code null} for none
   */
  public GroceryList setAddress(java.lang.String address) {
    this.address = address;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getDeliverer() {
    return deliverer;
  }

  /**
   * @param deliverer deliverer or {@code null} for none
   */
  public GroceryList setDeliverer(java.lang.String deliverer) {
    this.deliverer = deliverer;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.util.List<java.lang.String> getItems() {
    return items;
  }

  /**
   * @param items items or {@code null} for none
   */
  public GroceryList setItems(java.util.List<java.lang.String> items) {
    this.items = items;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getJobid() {
    return jobid;
  }

  /**
   * @param jobid jobid or {@code null} for none
   */
  public GroceryList setJobid(java.lang.Integer jobid) {
    this.jobid = jobid;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getNearby() {
    return nearby;
  }

  /**
   * @param nearby nearby or {@code null} for none
   */
  public GroceryList setNearby(java.lang.Integer nearby) {
    this.nearby = nearby;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getOwner() {
    return owner;
  }

  /**
   * @param owner owner or {@code null} for none
   */
  public GroceryList setOwner(java.lang.String owner) {
    this.owner = owner;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getStatus() {
    return status;
  }

  /**
   * @param status status or {@code null} for none
   */
  public GroceryList setStatus(java.lang.String status) {
    this.status = status;
    return this;
  }

  @Override
  public GroceryList set(String fieldName, Object value) {
    return (GroceryList) super.set(fieldName, value);
  }

  @Override
  public GroceryList clone() {
    return (GroceryList) super.clone();
  }

}