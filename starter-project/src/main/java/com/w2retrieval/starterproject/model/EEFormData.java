package com.w2retrieval.starterproject.model;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import org.bson.Document;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class EEFormData {
    protected List<EETaxData> eeTaxData;
}
