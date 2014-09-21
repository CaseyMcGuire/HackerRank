numTestCases = gets.chomp.to_i
nums = []
numTestCases.times {nums << gets.chomp.to_i}
sum = 0
nums.each do |int| 
    sum = 0
    int.to_s.chars.map(&:to_i).each{|i| sum += 1 if int % i == 0 unless i == 0}
    puts sum
end
