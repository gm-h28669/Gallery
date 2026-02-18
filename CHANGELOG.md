Changelog
==========

Version 1.2.2 *(2025-05-28)*
----------------------------

* Subsampling Scale Image View (new version 3.2.0):
  * For landscape images crop image to full screen. 
  * For portrait style images resize image to view height.
  
* Gallery (new version 1.2.2):
  * For landscape style images crop image to full screen. 
  * For portrait style images resize image to view height.
  * Improved fading transition to avoid jitter.
    * The Problem: Calculating transparency (alpha) for every pixel of a high-res image 60 times per second 
      is extremely CPU-intensive. This often causes frame drops, which we perceive as "jitter."
    * The Solution: By setting the layer type to HARDWARE, we tell Android to render the view into an off-screen 
      buffer (a texture) on the GPU. The GPU can then change the alpha of that entire texture almost instantaneously 
      without re-drawing the complex view on every frame.

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
