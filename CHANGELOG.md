Changelog
==========

Version 1.2.2 *(2025-02.20)*
----------------------------

* **General**
    * Updated target Android version to 15.
    * Upgraded `Subsampling Scale Image View` library to version 3.2.0.

* **Image Display & Zooming**
    * Changed scaling logic: Landscape images now fit to screen width, while portrait images scale to view height.
    * Changed behavior of Double-Tap Zoom:
        * If "1:1 zooming" is enabled, double-tapping toggles directly between fit-to-screen and full size.
        * New multi-step zoom: If 1:1 is disabled, double-tapping now zooms in/out in 25% increments.
    * Resolved "black flash" glitches on high-resolution screens by optimizing background tile rendering.

* **Slideshow Optimizations**
    * Eliminated transition jitter using GPU hardware acceleration for fade effects.
    * Added instant slideshow interruption: Tapping anywhere on the screen now reliably stops the show.
    * Reduced CPU/GPU stress by pausing high-resolution rendering during active transitions.
    * Specific performance optimizations for older high-resolution tablets (e.g., Samsung SM-T800).
    * Improved memory cleanup of GPU resources after slideshow completion.
  
Version 1.2.1 *(2024-09-28)*
----------------------------

* Updated target Android version to 14
* Added option to control video playback speed
* Added option to mute videos
* Replaced checkboxes with switches
* Added error indicator for media load failures
* Improve scrolling performance and interface
* Improved app lock logic and interface
* Added initial support for JPEG XL format (increased app size)
* Other minor bug fixes and improvements
* Added more translations

Version 1.2.0 *(2024-09-21)*
----------------------------

* Added initial support for JPEG XL format
* Updated target Android version to 14
* Added option to control video playback speed
* Added option to mute videos
* Replaced checkboxes with switches
* Added error indicator for media load failures
* Improved app lock logic and user interface
* Other minor bug fixes and improvements
* Added more translations

Version 1.1.3 *(2024-04-16)*
----------------------------

* Fixed black thumbnails for some images.
* Added some translations

Version 1.1.2 *(2024-03-10)*
----------------------------

* Fixed crash when playing videos.
* Fixed slideshow on Android 14.
* Added support for AVIF.
* Fixed position reset after device rotation.
* Fixed zooming screenshots when one to one double tap zoom enabled.
* Added some translations

Version 1.1.1 *(2024-01-10)*
----------------------------

* Removed fake app message when using the editor.
* Added some translations

Version 1.1.0 *(2024-01-02)*
----------------------------

* Removed proprietary panorama library
* Added some translations

Version 1.0.2 *(2023-12-30)*
----------------------------

* Fixed zooming in high-res images
* Added some translations

Version 1.0.1 *(2023-12-28)*
----------------------------

* Fixed privacy policy link
* Added some translation, UI/UX improvements
