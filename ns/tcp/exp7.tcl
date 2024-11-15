set ns [new Simulator]

set nf [open out.nam w]
$ns namtrace-all $nf

proc finish { } {
global ns nf
$ns flush-trace
close $nf
exec nam out.nam &
exit 0
}

set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]
set n3 [$ns node]
set n4 [$ns node]
set n5 [$ns node]
set n6 [$ns node]
set n7 [$ns node]

$ns duplex-link $n0 $n3 1Mb 10ms RED
$ns duplex-link $n1 $n3 1Mb 10ms RED
$ns duplex-link $n2 $n3 1Mb 10ms RED
$ns duplex-link $n3 $n4 1Mb 10ms RED
$ns duplex-link $n4 $n5 1Mb 10ms RED
$ns duplex-link $n4 $n6 1Mb 10ms RED
$ns duplex-link $n4 $n7 1Mb 10ms RED

$ns duplex-link-op $n0 $n3 orient right-up
$ns duplex-link-op $n1 $n3 orient right
$ns duplex-link-op $n2 $n3 orient right-down
$ns duplex-link-op $n3 $n4 orient middle
$ns duplex-link-op $n4 $n5 orient right-up
$ns duplex-link-op $n4 $n6 orient right
$ns duplex-link-op $n4 $n7 orient right-down

set udp0 [new Agent/UDP]
$ns attach-agent $n2 $udp0

set cbr0 [new Application/Traffic/CBR]
$cbr0 set packetSize_ 500
$cbr0 set interval_ 0.005
$cbr0 attach-agent $udp0

set null0 [new Agent/Null]
$ns attach-agent $n5 $null0

$ns connect $udp0 $null0

set udp1 [new Agent/UDP]
$ns attach-agent $n1 $udp1

set cbr1 [new Application/Traffic/CBR]
$cbr1 set packetSize_ 500
$cbr1 set interval_ 0.005
$cbr1 attach-agent $udp1

set null0 [new Agent/Null]
$ns attach-agent $n6 $null0

$ns connect $udp1 $null0

set udp2 [new Agent/UDP]
$ns attach-agent $n0 $udp2

set cbr2 [new Application/Traffic/CBR]
$cbr2 set packetSize_ 500
$cbr2 set interval_ 0.005
$cbr2 attach-agent $udp2

set null0 [new Agent/Null]
$ns attach-agent $n7 $null0

$ns connect $udp2 $null0

$udp0 set fid_ 1
$udp1 set fid_ 2
$udp2 set fid_ 3

$ns color 1 Red
$ns color 2 Green
$ns color 3 Blue

$ns at 0.0 "$cbr0 start"
$ns at 0.1 "$cbr1 start"
$ns at 0.2 "$cbr2 start"
$ns at 4.0 "$cbr2 stop"
$ns at 4.1 "$cbr1 stop"
$ns at 4.2 "$cbr0 stop"

$ns at 5.0 "finish"

$ns run
