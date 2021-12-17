package com.adventofcode;

import com.adventofcode.common.Day;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Day16 extends Day {

    public Day16() {
        super(16);
    }

    public int transmissionPosition = 0;

    private static String hexToBin(String hexadecimalString) {
        String value = new BigInteger(hexadecimalString, 16).toString(2);
        String formatPad = "%" + (hexadecimalString.length() * 4) + "s";
        return String.format(formatPad, value).replace(" ", "0");
    }

    private static int binToDec(String binaryString) {
        return Integer.parseInt(binaryString,2);
    }

    interface Packet {
        int version();
        int typeID();
        long value();
    }

    record LiteralPacket(int version, int typeID, long value) implements Packet{}

    record OperatorPacket(int version, int typeID, List<Packet> packets) implements Packet {
        public long value() {
            return switch (typeID) {
                case 0 -> packets.stream().mapToLong(Packet::value).sum();
                case 1 -> packets.stream().mapToLong(Packet::value).reduce(1, (a, b) -> a * b);
                case 2 -> packets.stream().mapToLong(Packet::value).min().orElseThrow();
                case 3 -> packets.stream().mapToLong(Packet::value).max().orElseThrow();
                case 5 -> packets.get(0).value() > packets.get(1).value() ? 1L : 0L;
                case 6 -> packets.get(0).value() < packets.get(1).value() ? 1L : 0L;
                case 7 -> packets.get(0).value() == packets.get(1).value() ? 1L : 0L;
                default -> throw new IllegalStateException("Valid packet typeID is between 1 and 7 but got: " + typeID);
            };
        }

        public int version() {
            return version + packets.stream().mapToInt(Packet::version).sum();
        }
    }

    public Packet parsePacket(String transmission) {
        int version = binToDec(transmission.substring(transmissionPosition, transmissionPosition + 3));
        int typeID = binToDec(transmission.substring(transmissionPosition + 3, transmissionPosition + 6));
        transmissionPosition += 6;
        return switch(typeID) {
            case 4  -> parseLiteralPacket(transmission, version, typeID);
            default -> parseOperatorPacket(transmission, version, typeID);
        };
    }

    public Packet parseOperatorPacket(String transmission, int version, int typeID) {
        int mode = Integer.parseInt(transmission.substring(transmissionPosition, transmissionPosition + 1));
        transmissionPosition++;
        switch (mode) {
            case 0 -> {
                int totalLengthPacket = binToDec(transmission.substring(transmissionPosition, transmissionPosition + 15));
                transmissionPosition += 15;
                int position = transmissionPosition;
                List<Packet> packets = new ArrayList<>();
                while (transmissionPosition - position < totalLengthPacket) {
                    packets.add(parsePacket(transmission));
                }
                return new OperatorPacket(version, typeID, packets);
            }
            default -> {
                int number = binToDec(transmission.substring(transmissionPosition, transmissionPosition + 11));
                transmissionPosition += 11;
                List<Packet> packets = IntStream.range(0, number).mapToObj(i -> parsePacket(transmission)).toList();
                return new OperatorPacket(version, typeID, packets);
            }
        }
    }

    public Packet parseLiteralPacket(String transmission, int version, int typeID) {
        long value = 0;
        do {
            value = (value << 4) + binToDec(transmission.substring(transmissionPosition + 1, transmissionPosition + 5));
            transmissionPosition += 5;
        } while (transmission.charAt(transmissionPosition - 5) != '0');
        return new LiteralPacket(version, typeID, value);
    }

    public Packet parsePacketHierarchy(String transmission) {
        transmissionPosition = 0;
        return parsePacket(transmission);
    }

    @Override
    public Object partOne() {
        Packet packet = parsePacket(hexToBin(getDataAsString()));
        return packet.version();
    }

    @Override
    public Object partTwo() {
        Packet packet = parsePacketHierarchy(hexToBin(getDataAsString()));
        return packet.value();
    }

    public static void main(String[] args) {
        new Day16().solveTasks();
    }
}
