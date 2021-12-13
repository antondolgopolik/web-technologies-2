package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.*;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ApplianceDAOImpl implements ApplianceDAO {

    @Override
    public Appliance find(Criteria criteria) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(getClass().getResourceAsStream("/appliances_db.xml"));
            doc.getDocumentElement().normalize();
            // Get nodes
            NodeList nodeList = doc.getElementsByTagName(criteria.getGroupSearchName());
            // Find appliance
            switch (criteria.getGroupSearchName()) {
                case "Oven" -> {
                    return findOven(nodeList, criteria);
                }
                case "Laptop" -> {
                    return findLaptop(nodeList, criteria);
                }
                case "Refrigerator" -> {
                    return findRefrigerator(nodeList, criteria);
                }
                case "VacuumCleaner" -> {
                    return findVacuumCleaner(nodeList, criteria);
                }
                case "TabletPC" -> {
                    return findTabletPC(nodeList, criteria);
                }
                case "Speakers" -> {
                    return findSpeakers(nodeList, criteria);
                }
                default -> throw new RuntimeException("Unknown group search name!");
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Oven findOven(NodeList nodeList, Criteria criteria) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                // Read fields
                double powerConsumption = Double.parseDouble(getFieldText(element, SearchCriteria.Oven.POWER_CONSUMPTION));
                double weight = Double.parseDouble(getFieldText(element, SearchCriteria.Oven.WEIGHT));
                double capacity = Double.parseDouble(getFieldText(element, SearchCriteria.Oven.CAPACITY));
                double depth = Double.parseDouble(getFieldText(element, SearchCriteria.Oven.DEPTH));
                double height = Double.parseDouble(getFieldText(element, SearchCriteria.Oven.HEIGHT));
                double width = Double.parseDouble(getFieldText(element, SearchCriteria.Oven.WIDTH));
                // Check fields
                Map<String, Object> map = criteria.getCriteria();
                if (checkField(map, SearchCriteria.Oven.POWER_CONSUMPTION, powerConsumption) &&
                        checkField(map, SearchCriteria.Oven.WEIGHT, weight) &&
                        checkField(map, SearchCriteria.Oven.CAPACITY, capacity) &&
                        checkField(map, SearchCriteria.Oven.DEPTH, depth) &&
                        checkField(map, SearchCriteria.Oven.HEIGHT, height) &&
                        checkField(map, SearchCriteria.Oven.WIDTH, width)) {
                    // Create
                    Oven oven = new Oven();
                    oven.setPowerConsumption(powerConsumption);
                    oven.setWeight(weight);
                    oven.setCapacity(capacity);
                    oven.setDepth(depth);
                    oven.setHeight(height);
                    oven.setWidth(width);
                    // Return
                    return oven;
                }
            }
        }
        return null;
    }

    private Laptop findLaptop(NodeList nodeList, Criteria criteria) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                // Read fields
                double batteryCapacity = Double.parseDouble(getFieldText(element, SearchCriteria.Laptop.BATTERY_CAPACITY));
                String os = getFieldText(element, SearchCriteria.Laptop.OS);
                int memoryRom = Integer.parseInt(getFieldText(element, SearchCriteria.Laptop.MEMORY_ROM));
                int systemMemory = Integer.parseInt(getFieldText(element, SearchCriteria.Laptop.SYSTEM_MEMORY));
                double cpu = Double.parseDouble(getFieldText(element, SearchCriteria.Laptop.CPU));
                int displayInches = Integer.parseInt(getFieldText(element, SearchCriteria.Laptop.DISPLAY_INCHS));
                // Check fields
                Map<String, Object> map = criteria.getCriteria();
                if (checkField(map, SearchCriteria.Laptop.BATTERY_CAPACITY, batteryCapacity) &&
                        checkField(map, SearchCriteria.Laptop.OS, os) &&
                        checkField(map, SearchCriteria.Laptop.MEMORY_ROM, memoryRom) &&
                        checkField(map, SearchCriteria.Laptop.SYSTEM_MEMORY, systemMemory) &&
                        checkField(map, SearchCriteria.Laptop.CPU, cpu) &&
                        checkField(map, SearchCriteria.Laptop.DISPLAY_INCHS, displayInches)) {
                    // Create
                    Laptop laptop = new Laptop();
                    laptop.setBatteryCapacity(batteryCapacity);
                    laptop.setOs(os);
                    laptop.setMemoryRom(memoryRom);
                    laptop.setSystemMemory(systemMemory);
                    laptop.setCpu(cpu);
                    laptop.setDisplayInches(displayInches);
                    // Return
                    return laptop;
                }
            }
        }
        return null;
    }

    private Refrigerator findRefrigerator(NodeList nodeList, Criteria criteria) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                // Read fields
                double powerConsumption = Double.parseDouble(getFieldText(element, SearchCriteria.Refrigerator.POWER_CONSUMPTION));
                double weight = Double.parseDouble(getFieldText(element, SearchCriteria.Refrigerator.WEIGHT));
                double freezerCapacity = Double.parseDouble(getFieldText(element, SearchCriteria.Refrigerator.FREEZER_CAPACITY));
                double overallCapacity = Double.parseDouble(getFieldText(element, SearchCriteria.Refrigerator.OVERALL_CAPACITY));
                double height = Double.parseDouble(getFieldText(element, SearchCriteria.Refrigerator.HEIGHT));
                double width = Double.parseDouble(getFieldText(element, SearchCriteria.Refrigerator.WIDTH));
                // Check fields
                Map<String, Object> map = criteria.getCriteria();
                if (checkField(map, SearchCriteria.Refrigerator.POWER_CONSUMPTION, powerConsumption) &&
                        checkField(map, SearchCriteria.Refrigerator.WEIGHT, weight) &&
                        checkField(map, SearchCriteria.Refrigerator.FREEZER_CAPACITY, freezerCapacity) &&
                        checkField(map, SearchCriteria.Refrigerator.OVERALL_CAPACITY, overallCapacity) &&
                        checkField(map, SearchCriteria.Refrigerator.HEIGHT, height) &&
                        checkField(map, SearchCriteria.Refrigerator.WIDTH, width)) {
                    // Create
                    Refrigerator refrigerator = new Refrigerator();
                    refrigerator.setPowerConsumption(powerConsumption);
                    refrigerator.setWeight(weight);
                    refrigerator.setFreezerCapacity(freezerCapacity);
                    refrigerator.setOverallCapacity(overallCapacity);
                    refrigerator.setHeight(height);
                    refrigerator.setWeight(weight);
                    // Return
                    return refrigerator;
                }
            }
        }
        return null;
    }

    private VacuumCleaner findVacuumCleaner(NodeList nodeList, Criteria criteria) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                // Read fields
                double powerConsumption = Double.parseDouble(getFieldText(element, SearchCriteria.VacuumCleaner.POWER_CONSUMPTION));
                String filterType = getFieldText(element, SearchCriteria.VacuumCleaner.FILTER_TYPE);
                String bagType = getFieldText(element, SearchCriteria.VacuumCleaner.BAG_TYPE);
                String wandType = getFieldText(element, SearchCriteria.VacuumCleaner.WAND_TYPE);
                double motorSpeedRegulation = Double.parseDouble(getFieldText(element, SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION));
                double cleaningWidth = Double.parseDouble(getFieldText(element, SearchCriteria.VacuumCleaner.CLEANING_WIDTH));
                // Check fields
                Map<String, Object> map = criteria.getCriteria();
                if (checkField(map, SearchCriteria.VacuumCleaner.POWER_CONSUMPTION, powerConsumption) &&
                        checkField(map, SearchCriteria.VacuumCleaner.FILTER_TYPE, filterType) &&
                        checkField(map, SearchCriteria.VacuumCleaner.BAG_TYPE, bagType) &&
                        checkField(map, SearchCriteria.VacuumCleaner.WAND_TYPE, wandType) &&
                        checkField(map, SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION, motorSpeedRegulation) &&
                        checkField(map, SearchCriteria.VacuumCleaner.CLEANING_WIDTH, cleaningWidth)) {
                    // Create
                    VacuumCleaner vacuumCleaner = new VacuumCleaner();
                    vacuumCleaner.setPowerConsumption(powerConsumption);
                    vacuumCleaner.setFilterType(filterType);
                    vacuumCleaner.setBagType(bagType);
                    vacuumCleaner.setWandType(wandType);
                    vacuumCleaner.setMotorSpeedRegulation(motorSpeedRegulation);
                    vacuumCleaner.setCleaningWidth(cleaningWidth);
                    // Return
                    return vacuumCleaner;
                }
            }
        }
        return null;
    }

    private TabletPC findTabletPC(NodeList nodeList, Criteria criteria) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                // Read fields
                double batteryCapacity = Double.parseDouble(getFieldText(element, SearchCriteria.TabletPC.BATTERY_CAPACITY));
                int displayInches = Integer.parseInt(getFieldText(element, SearchCriteria.TabletPC.DISPLAY_INCHES));
                int memoryRom = Integer.parseInt(getFieldText(element, SearchCriteria.TabletPC.MEMORY_ROM));
                int flashMemoryCapacity = Integer.parseInt(getFieldText(element, SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY));
                String color = getFieldText(element, SearchCriteria.TabletPC.COLOR);
                // Check fields
                Map<String, Object> map = criteria.getCriteria();
                if (checkField(map, SearchCriteria.TabletPC.BATTERY_CAPACITY, batteryCapacity) &&
                        checkField(map, SearchCriteria.TabletPC.DISPLAY_INCHES, displayInches) &&
                        checkField(map, SearchCriteria.TabletPC.MEMORY_ROM, memoryRom) &&
                        checkField(map, SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY, flashMemoryCapacity) &&
                        checkField(map, SearchCriteria.TabletPC.COLOR, color)) {
                    // Create
                    TabletPC tabletPc = new TabletPC();
                    tabletPc.setBatteryCapacity(batteryCapacity);
                    tabletPc.setDisplayInches(displayInches);
                    tabletPc.setMemoryRom(memoryRom);
                    tabletPc.setFlashMemoryCapacity(flashMemoryCapacity);
                    // Return
                    return tabletPc;
                }
            }
        }
        return null;
    }

    private Speakers findSpeakers(NodeList nodeList, Criteria criteria) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                // Read fields
                double powerConsumption = Double.parseDouble(getFieldText(element, SearchCriteria.Speakers.POWER_CONSUMPTION));
                int numberOfSpeakers = Integer.parseInt(getFieldText(element, SearchCriteria.Speakers.NUMBER_OF_SPEAKERS));
                String frequencyRange = getFieldText(element, SearchCriteria.Speakers.FREQUENCY_RANGE);
                double cordLength = Double.parseDouble(getFieldText(element, SearchCriteria.Speakers.CORD_LENGTH));
                // Check fields
                Map<String, Object> map = criteria.getCriteria();
                if (checkField(map, SearchCriteria.Speakers.POWER_CONSUMPTION, powerConsumption) &&
                        checkField(map, SearchCriteria.Speakers.NUMBER_OF_SPEAKERS, numberOfSpeakers) &&
                        checkField(map, SearchCriteria.Speakers.FREQUENCY_RANGE, frequencyRange) &&
                        checkField(map, SearchCriteria.Speakers.CORD_LENGTH, cordLength)) {
                    // Create
                    Speakers speakers = new Speakers();
                    speakers.setPowerConsumption(powerConsumption);
                    speakers.setNumberOfSpeakers(numberOfSpeakers);
                    speakers.setFrequencyRange(frequencyRange);
                    speakers.setCordLength(cordLength);
                    // Return
                    return speakers;
                }
            }
        }
        return null;
    }

    private String getFieldText(Element element, Enum<?> e) {
        return element.getElementsByTagName(e.toString()).item(0).getTextContent();
    }

    private boolean checkField(Map<String, Object> map, Enum<?> e, Object value) {
        String key = e.toString();
        return !map.containsKey(key) || map.get(key).equals(value);
    }
}