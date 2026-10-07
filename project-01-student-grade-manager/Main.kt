fun main() { 
    val students = mapOf( "Nima" to listOf(20, 10, 18, 11, 18),
                         "Maryam" to listOf(20, 14, 12, 19, 11),
                         "Ali" to listOf(11, 15, 12, 18, 14),
                         "Nazi" to listOf(10, 10, 11, 20, 17),
                         "Karen" to listOf(16, 17, 14, 17, 20)
                        )
    fun average(list: Map<String, List<Int>>){
        val listAvg: MutableList<Double> = mutableListOf()
        val mapAvg: MutableMap<String, Double> = mutableMapOf()
        
        for ((name, score) in list) {
            val avg = score.sum().toDouble() / score.size
            listAvg.add(avg)
            mapAvg.put(name, avg)
        }
        
        listAvg.sort()   
        
        val minAvg = listAvg.first()
        val maxAvg = listAvg.last()
        
        
		var showInfo = ""
        var minName = ""
        var maxName = ""
		
        val sortedStudents = mapAvg.entries.sortedByDescending { it.value }
		var rank = 1
        
        for ((name, avg) in sortedStudents) {
            showInfo = "$rank. $name -> $avg"    
    		rank++
            
            if (avg > 10.00) 
               showInfo += "\tState: Passed"
            else 
               showInfo += "\tState: Failed"
           
             println(showInfo)
            
            
            if (avg == minAvg) minName = name
            if (avg == maxAvg) maxName = name
        }
       println("\nMinimum avg is for $minName: $minAvg\nMaximum avg is for $maxName: $maxAvg")
    }
    
    average(students)
}