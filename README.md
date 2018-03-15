# Test

## Description

Problem Statement You are arranging a weird game for a team building exercise. In this game there are certain locations that people can stand at, and from each location there are paths that lead to other locations, but there are not necessarily paths that lead directly back. You have everything set up, but you need to know two important numbers. There might be some locations from which every other location can be reached. There might also be locations that can be reached from every other location. You need to know how many of each of these there are.

Create a class TeamBuilder with a method specialLocations that takes a String[] paths that describes the way the locations have been connected, and returns a int[] with exactly two elements, the first one is the number of locations that can reach all other locations, and the second one is the number of locations that are reachable by all other locations. Each element of paths will be a String containing as many characters as there are elements in paths. The i-th element of paths (beginning with the 0-th element) will contain a '1' (all quotes are for clarity only) in position j if there is a path that leads directly from i to j, and a '0' if there is not a
path that leads directly from i to j.

## Build

mvn clean package

## Run

java -jar target/teambuilder-0.0.1-SNAPSHOT.jar "010" "000" "110"

