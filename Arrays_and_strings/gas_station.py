"""
There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station 
to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.

Given two integer arrays gas and cost, return the starting gas station's index if you can 
travel around the circuit once in the clockwise direction, otherwise return -1. 
If there exists a solution, it is guaranteed to be unique
"""
class Solution(object):
    def canCompleteCircuit(self, gas, cost):
        """
        :type gas: List[int]
        :type cost: List[int]
        :rtype: int
        """
        n = len(gas)
        total_gas = 0
        total_cost = 0
        start_index = 0

        for i in range(n):
            total_gas += gas[i]
            total_cost += cost[i]

        if total_gas < total_cost:
            return -1

        tank = 0
        for i in range(n):
            tank += gas[i] - cost[i]
            if tank < 0:
                start_index = i + 1
                tank = 0

        return start_index