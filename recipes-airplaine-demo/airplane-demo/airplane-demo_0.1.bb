SUMMARY = "Qt5 airplane application"
DESCRIPTION = "Qt5 airplane application"
HOMEPAGE = "https://github.com/Invisto-your-interface-partner/DemoAirplaneCockpit"
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

PROVIDES += "airplane-demo"

DEPENDS += "\
        qtbase \
        qtquickcontrols \
        qtquickcontrols2 \
        qtscxml \
        qtserialport \
        qtsvg \
        qttools-native \
        qttranslations \
"

PV = "1.0+git${SRCPV}"

SRC_URI = "git://git@github.com/Invisto-your-interface-partner/DemoAirplaneCockpit.git;protocol=ssh;branch=qt5 \
        file://airplane-demo.service \
"

SRCREV = "113ef1f81e6693e3174855003ff40cb9a28447ad"

S = "${WORKDIR}/git"

inherit qmake5 systemd

RDEPENDS:${PN} += "\
        qtsvg \
"

#SYSTEMD_SERVICE_${PN} = "airplane-demo.service"

FILES_SOLIBSDEV = ""
INSANE_SKIP:${PN} += "dev-so"

#do_install:append() {
#        # Systemd
#        install -d ${D}${systemd_system_unitdir}
#        install -m 0644 ${WORKDIR}/airplane-demo.service ${D}${systemd_system_unitdir}
#}

FILES:${PN} += " \
  ${bindir}/DemoAirplaneCockpit \
#${systemd_unitdir}/system/airplane-demo.service \
"

