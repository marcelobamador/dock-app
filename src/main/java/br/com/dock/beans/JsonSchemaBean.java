package br.com.dock.beans;

import java.io.InputStream;
import java.util.Objects;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.context.annotation.Configuration;

import br.com.dock.exception.JsonValidationException;
import br.com.dock.exception.SchemaNotFoundException;


@Configuration
public class JsonSchemaBean {

    public Schema getJsonSchema(String schema) {
        try (InputStream inputStream = getClass().getResourceAsStream(schema)) {
            JSONObject rawSchema = new JSONObject(
            		new JSONTokener(Objects.requireNonNull(inputStream)));

            return SchemaLoader.load(rawSchema);
        } catch (Exception e) {
            throw new SchemaNotFoundException("Could not locate schema with name: " + schema);
        }
    }

    public void validateJson(JSONObject jsonObject, String schema) {
        try {
            getJsonSchema(schema).validate(jsonObject);
        } catch (ValidationException e) {
            throw new JsonValidationException(e.getMessage());
        }
    }

}
