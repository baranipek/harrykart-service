import javax.xml.bind.annotation.*
@XmlRootElement(name = "harryKart")
@XmlAccessorType(XmlAccessType.FIELD)
data class HarryKartRequest(
    @field:XmlElement(name = "numberOfLoops")
    var numberOfLoops: Int = 0,

    @field:XmlElement(name = "startList")
    var startList: StartList = StartList(),

    @field:XmlElement(name = "powerUps")
    var powerUps: PowerUps = PowerUps()
) {
    constructor() : this(0, StartList(), PowerUps())
}

@XmlAccessorType(XmlAccessType.FIELD)
data class StartList(
    @field:XmlElement(name = "participant")
    var participants: MutableList<Participant> = mutableListOf()
)

@XmlAccessorType(XmlAccessType.FIELD)
data class Participant(
    @field:XmlElement(name = "lane")
    var lane: Int = 0,

    @field:XmlElement(name = "name")
    var name: String = "",

    @field:XmlElement(name = "baseSpeed")
    var baseSpeed: Int = 0
)

@XmlAccessorType(XmlAccessType.FIELD)
data class PowerUps(
    @field:XmlElement(name = "loop")
    var loops: MutableList<Loop> = mutableListOf()
)

@XmlAccessorType(XmlAccessType.FIELD)
data class Loop(
    @field:XmlAttribute(name = "number")
    var number: Int = 0,

    @field:XmlElement(name = "lane")
    var lanes: MutableList<Lane> = mutableListOf()
)

@XmlAccessorType(XmlAccessType.FIELD)
data class Lane(
    @field:XmlAttribute(name = "number")
    var number: Int = 0,

    @field:XmlValue
    var value: Int = 0
)