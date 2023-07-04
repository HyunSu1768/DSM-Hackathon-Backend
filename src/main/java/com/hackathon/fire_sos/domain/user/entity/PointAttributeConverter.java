package com.hackathon.fire_sos.domain.user.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.io.WKBReader;
import org.locationtech.jts.io.WKBWriter;
import org.springframework.data.geo.Point;

import java.sql.SQLException;

@Converter(autoApply = true)
public class PointAttributeConverter implements AttributeConverter<Point, byte[]> {

    @Override
    public byte[] convertToDatabaseColumn(Point attribute) {
        if (attribute == null) {
            return null;
        }

        try {
            WKBWriter writer = new WKBWriter();
            byte[] bytes = writer.write((Geometry) new GeometryFactory().createPoint(new Coordinate(attribute.getX(), attribute.getY())));
            return bytes;
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert Point to byte[]", e);
        }
    }

    @Override
    public Point convertToEntityAttribute(byte[] dbData) {
        if (dbData == null) {
            return null;
        }

        try {
            WKBReader reader = new WKBReader();
            Geometry geometry = reader.read(dbData);
            Coordinate coordinate = geometry.getCoordinate();
            return new Point(coordinate.x, coordinate.y);
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert byte[] to Point", e);
        }
    }
}
