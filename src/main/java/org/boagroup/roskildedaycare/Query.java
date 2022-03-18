package org.boagroup.roskildedaycare;

public record Query(String TableName, String columns, String conditions) {}
